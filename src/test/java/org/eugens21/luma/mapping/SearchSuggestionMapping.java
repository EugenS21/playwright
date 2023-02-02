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
        val typeMap = this.modelMapper.createTypeMap(org.eugens21.luma.web.pages.model.search_results.SearchSuggestion.class, SearchSuggestion.class);
        typeMap.addMapping(e -> e.getSuggestionDetails().getKey(), SearchSuggestion::setSuggestion);
        typeMap.addMapping(e -> e.getSuggestionDetails().getValue(), SearchSuggestion::setQuantity);
    }

    public SearchSuggestion getSearchSuggestion(org.eugens21.luma.web.pages.model.search_results.SearchSuggestion searchSuggestion) {
        return modelMapper.map(searchSuggestion, SearchSuggestion.class);
    }

}
