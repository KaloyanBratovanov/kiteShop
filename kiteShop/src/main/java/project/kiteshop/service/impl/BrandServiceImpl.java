package project.kiteshop.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import project.kiteshop.models.entities.BrandEntity;
import project.kiteshop.repository.BrandRepository;
import project.kiteshop.service.BrandService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final Resource brandsFile;
    private final Gson gson;
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(
            @Value("classpath:init/brands.json") Resource brandsFile,
            Gson gson,
            BrandRepository brandRepository,
            ModelMapper modelMapper) {
        this.brandsFile = brandsFile;
        this.gson = gson;
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedBrands() {

        if (brandRepository.count() == 0){
            try {
                BrandEntity[] brandEntities =
                        gson.fromJson(Files.readString(Path.of(brandsFile.getURI())), BrandEntity[].class);

                Arrays.stream(brandEntities)
                        .forEach(brandRepository::save);

            } catch (IOException e) {
                throw new IllegalStateException("Cannot seed brand");
            }
        }
    }

    @Override
    public BrandEntity findByName(String brand) {
        return brandRepository.findByName(brand).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<String> findAllBrands() {
        return brandRepository.findAllBrandNames();
    }
}
