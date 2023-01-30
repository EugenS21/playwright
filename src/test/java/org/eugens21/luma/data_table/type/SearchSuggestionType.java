package org.eugens21.luma.data_table.type;

import io.cucumber.java.DataTableType;
import org.eugens21.luma.data_table.model.SearchSuggestion;

import java.util.Map;

import static java.lang.Integer.valueOf;

public class SearchSuggestionType {

    @DataTableType
    public SearchSuggestion searchSuggestion(Map<String, String> entry) {
        return SearchSuggestion.builder()
                .suggestion(entry.get("Suggestion"))
                .quantity(valueOf(entry.get("Quantity")))
                .build();
    }

}
