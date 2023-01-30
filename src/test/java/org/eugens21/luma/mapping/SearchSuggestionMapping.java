package org.eugens21.luma.mapping;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.eugens21.luma.data_table.model.SearchSuggestion;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SuppressWarnings("all")
public class SearchSuggestionMapping {

    ModelMapper modelMapper;

    @Autowired
    public SearchSuggestionMapping(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        val typeMap = this.modelMapper.createTypeMap(org.eugens21.luma.web.model.SearchSuggestion.class, SearchSuggestion.class);
        typeMap.addMapping(e -> e.getOptionName().getContent(), SearchSuggestion::setSuggestion);
        typeMap.addMappings(mapper -> mapper.using(ctx -> Integer.valueOf(ctx.getSource().toString()))
                .map(e -> e.getAmount().getContent(), SearchSuggestion::setQuantity));
    }

    public SearchSuggestion getSearchSuggestion(org.eugens21.luma.web.model.SearchSuggestion searchSuggestion) {
        return modelMapper.map(searchSuggestion, SearchSuggestion.class);
    }

}
