package seedu.address.commons.util;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Deserialize non-concrete Collection type {@code observableArrayList} explicitly so that Jackson correctly handles
 * {@code ObservableList<String>} when reading JSON testcases.
 */
public class ObservableListDeserializer extends JsonDeserializer<ObservableList<String>> {
    @Override
    public ObservableList<String> deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        ArrayNode node = parser.getCodec().readTree(parser);
        ObservableList<String> internalList = FXCollections.observableArrayList();
        Iterator<JsonNode> elements = node.elements();
        while (elements.hasNext()) {
            internalList.add(elements.next().asText());
        }
        return internalList;
    }
}
