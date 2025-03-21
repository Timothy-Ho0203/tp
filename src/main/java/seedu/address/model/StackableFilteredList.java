package seedu.address.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.util.function.Predicate;

public class StackableFilteredList<E> {
    private ObservableList<E> originalList;
    private FilteredList<E> filteredList;
    private Predicate<E> combinedPredicate;

    public StackableFilteredList(ObservableList<E> list) {
        this.originalList = list;
        this.filteredList = new FilteredList<>(list);
        this.combinedPredicate = unused -> true;
    }

    public void addPredicate(Predicate<E> newPredicate) {
        combinedPredicate = combinedPredicate.and(newPredicate);
        filteredList.setPredicate(combinedPredicate);
    }

    public void clearFilters() {
        combinedPredicate = item -> true;
        filteredList.setPredicate(combinedPredicate);
    }

    public ObservableList<E> getOriginalList() {
        return originalList;
    }

    public FilteredList<E> getFilteredList() {
        return filteredList;
    }
}
