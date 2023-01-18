package org.eugens21.luma.mapping;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.eugens21.luma.data_table.model.ProductInfo;
import org.eugens21.luma.web.model.ProductColor;
import org.eugens21.luma.web.model.ProductItemInfo;
import org.eugens21.luma.web.model.ProductSize;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SuppressWarnings("all")
public class ProductInfoMapping {

    ModelMapper modelMapper;

    @Autowired
    public ProductInfoMapping(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        val typeMap = this.modelMapper.createTypeMap(ProductItemInfo.class, ProductInfo.class);
        typeMap.addMapping(e -> e.getName().getText(), ProductInfo::setName)
//                .addMapping(e -> Try(() -> e.getProductReview().getRating().getPercentage().getContent()).getOrElse(EMPTY), ProductInfo::setRating)
//                .addMapping(e -> Try(() -> e.getProductReview().getReview().getReviews().getText()).getOrElse(EMPTY), ProductInfo::setReviews)
                .addMapping(e -> e.getCost().getPrice(), ProductInfo::setPrice);
        typeMap.addMappings(mapper -> mapper.using(ctx -> ((List<ProductSize>) ctx.getSource()).stream()
                        .map(el -> el.getSize().getText()).collect(toList()))
                .map(ProductItemInfo::getAvailableSizes, ProductInfo::setAvailableSizes));
        typeMap.addMappings(mapper -> mapper.using(ctx -> ((List<ProductColor>) ctx.getSource()).stream()
                        .map(el -> el.getColor().getAttribute("aria-label")).collect(toList()))
                .map(ProductItemInfo::getAvailableColors, ProductInfo::setAvailableColors));

    }

    public ProductInfo getProductInfo(ProductItemInfo productItemInfo) {
        return modelMapper.map(productItemInfo, ProductInfo.class);
    }

}
