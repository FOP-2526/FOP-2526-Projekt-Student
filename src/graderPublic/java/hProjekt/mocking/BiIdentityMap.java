package hProjekt.mocking;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.NotNull;

import com.google.common.collect.BiMap;

public class BiIdentityMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V> {

    private static class IdentitySet<K, V> extends AbstractSet<Entry<K, V>> {
        private List<Entry<K, V>> elements = new ArrayList<>();

        public IdentitySet() {

        }

        public IdentitySet(List<Entry<K, V>> elements) {
            this.elements.addAll(elements);
        }

        @Override
        public boolean contains(Object o) {
            if (o == null) {
                return false;
            }
            if (!(o instanceof Map.Entry<?, ?> other)) {
                return false;
            }

            return elements.stream().anyMatch(entry -> {
                Object otherKey = other.getKey();
                Object otherValue = other.getValue();
                K thisKey = entry.getKey();
                V thisValue = entry.getValue();

                return (otherKey == thisKey && otherValue == thisValue)
                        || (otherKey == thisValue && otherValue == thisKey);
            });
        }

        @Override
        public boolean remove(Object o) {
            if (contains(o)) {
                elements.removeIf(element -> element.getKey() == ((Entry) o).getKey()
                        || element.getValue() == ((Entry) o).getValue());
            }
            return false;
        }

        @Override
        public boolean add(Entry<K, V> kvEntry) {
            if (contains(kvEntry)) {
                return false;
            }
            elements.add(kvEntry);
            return true;
        }

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return elements.iterator();
        }

        @Override
        public int size() {
            return elements.size();
        }
    }

    private IdentitySet<K, V> elements = new IdentitySet<>();

    public BiIdentityMap(Map<K, V> elements) {
        putAll(elements);
    }

    public BiIdentityMap() {

    }

    @Override
    public V put(K key, V value) {
        if (containsValue(value)) {
            throw new IllegalStateException(
                    "Could not add key-value-pair as value %s is already present".formatted(value));
        }
        V oldValue = null;
        if (containsKey(key)) {
            oldValue = get(key);
            remove(key);
        }
        elements.add(new SimpleEntry<>(key, value));
        return oldValue;
    }

    @Override
    public V get(Object key) {
        return elements.stream().filter(element -> element.getKey() == key).findAny().map(Entry::getValue).orElse(null);
    }

    @Override
    public boolean remove(Object key, Object value) {
        Object curValue = get(key);
        if (curValue != value || (curValue == null && !containsKey(key))) {
            return false;
        }
        remove(key);
        return true;
    }

    @Override
    public V remove(Object key) {
        V oldValue = get(key);
        if (oldValue == null) {
            return null;
        }
        elements.remove(Map.entry(key, oldValue));
        return oldValue;
    }

    @Override
    public boolean containsKey(Object key) {
        return elements.stream().anyMatch(element -> element.getKey() == key);
    }

    @Override
    public boolean containsValue(Object value) {
        return elements.stream().anyMatch(element -> element.getValue() == value);
    }

    @Override
    public @Nullable V forcePut(@Nullable K key, @Nullable V value) {
        V oldValue = null;
        if (containsKey(key)) {
            oldValue = get(key);
            elements.removeIf(kvEntry -> kvEntry.getKey() == key || kvEntry.getValue() == value);
        }
        elements.add(Map.entry(key, value));
        return oldValue;
    }

    @Override
    public BiMap<V, K> inverse() {
        BiIdentityMap<V, K> newMap = new BiIdentityMap<>();

        List<Entry<V, K>> entries = elements.stream().map(e -> new SimpleEntry<>(e.getValue(), e.getKey()))
                .collect(Collectors.toList());

        newMap.elements = new IdentitySet<>(entries);

        return newMap;
    }

    @Override
    public @NotNull Set<Entry<K, V>> entrySet() {
        return elements;
    }

    @Override
    public @NotNull Set<V> values() {
        return elements.stream().map(Entry::getValue).collect(Collectors.toSet());
    }
}
