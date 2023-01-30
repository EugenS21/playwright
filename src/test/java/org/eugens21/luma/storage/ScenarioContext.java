package org.eugens21.luma.storage;

import io.cucumber.spring.ScenarioScope;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.eugens21.luma.enums.StorageKey;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@ScenarioScope
@SuppressWarnings("all")
public class ScenarioContext {

    Map<StorageKey, Object> store;
    @Getter
    SoftAssertions softAssertions;

    public ScenarioContext() {
        this.softAssertions = new SoftAssertions();
        this.store = new HashMap<>();
    }

    public void addValue(StorageKey key, Object value) {
        store.put(key, value);
    }

    public <T> T getValue(StorageKey key, Class<T> clazz) {
        return clazz.cast(store.get(key));
    }

    public <T> List<T> getListValue(StorageKey key, Class<T> clazz){
        return (List<T>) store.get(key);
    }

    public boolean containsKey(StorageKey key) {
        return store.containsKey(key);
    }

}
