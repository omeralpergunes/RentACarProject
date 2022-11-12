package kodluyoruz.rentAcar1.business.concretes;

import kodluyoruz.rentAcar1.business.abstracts.BrandService;
import kodluyoruz.rentAcar1.business.requests.saveRequests.SaveBrandRequestDto;
import kodluyoruz.rentAcar1.business.requests.updateRequests.UpdateBrandRequest;
import kodluyoruz.rentAcar1.business.responses.BrandResponseDto;
import kodluyoruz.rentAcar1.entities.Brand;
import kodluyoruz.rentAcar1.exceptions.RentException;
import kodluyoruz.rentAcar1.repository.BrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelMapper modelMapper;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandResponseDto> getAll() {

        List<Brand> brands = brandRepository.findAll();

        List<BrandResponseDto> brandResponseDtos = new ArrayList<BrandResponseDto>();

        for (Brand brand : brands) {
            BrandResponseDto brandResponseDto = modelMapper.map(brand, BrandResponseDto.class);
            brandResponseDtos.add(brandResponseDto);
        }
        return brandResponseDtos;
    }

    @Override
    public Integer add(SaveBrandRequestDto saveBrandRequestDto) {
        Brand brand = modelMapper.map(saveBrandRequestDto, Brand.class);
        brand = brandRepository.save(brand);
        return brand.getId();
    }

    @Override
    public boolean delete(Integer brandId) {
        brandRepository.deleteById(brandId);
        return !brandRepository.existsById(brandId);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest, Integer id) throws RentException {
        Brand brand = brandRepository.findById(id).get();
        brand.setName(updateBrandRequest.getMarka());
        brandRepository.save(brand);
    }

}
