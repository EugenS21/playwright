package org.eugens21.luma.storage;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.luma.enums.StorageKey;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ScenarioContext {

    Map<StorageKey, Object> store;

    public ScenarioContext() {
        this.store = new HashMap<>();
    }

    public void addValue(StorageKey key, Object value) {
        store.put(key, value);
    }

    public <T> T getValue(StorageKey key, Class<T> clazz) {
        return clazz.cast(store.get(key));
    }

    public boolean containsKey(StorageKey key) {
        return store.containsKey(key);
    }

}
