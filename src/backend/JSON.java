package backend;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class that help you with the JSON management between js and Java
 */
public class JSON implements JsonObject{

    // Elements is a simple ArrayList that store all the JsonObjects
    private ArrayList<JsonObject> elements = new ArrayList<>();

    /**
     * Stores an element into the JSON
     * @param o The JsonObject you want to add
     * */
    public void add(JsonObject o){
        elements.add(o);
        System.out.println("Element added.");
    }

    /**
     * Add a collection into the JSON
     * @param col The Collection you want to add
     * */
    public void addAll(Collection<JsonObject> col){
        elements.addAll(col);
    }

    /**
     * Return the position of the JsonObject
     * @param o The JsonObject that you want the position
     * @return Position of the element.
     * */
    public int indexOf(JsonObject o){
        return elements.indexOf(o);
    }

    /**
     * Replace the element e1 with the e2
     * @param e1 The element you want to edit
     * @param e2 The same element edited
     * */
    public void edit(JsonObject e1, JsonObject e2){
        int position = elements.indexOf(e1);
        elements.set(position, e2);
        System.out.println("Element edited.");
    }

    /**
     * Delete a JsonObject
     * @param o The JsonObject you want to delete
     * */
    public void delete(JsonObject o){
        elements.remove(o);
        System.out.println("Element removed.");
    }

    /**
     * Delete a JsonObject by his position in JSON
     * @param i The position of the element you want to delete.
     * */
    public void delete(int i){
        elements.remove(i);
        System.out.println("Element removed.");
    }

    /**
     * Delete all the elements inside the JSON
     * */
    public void clear(){
        elements.clear();
        System.out.println("JSON clear.");
    }

    /**
     * Evaluate if this JSON is empty
     * @return Returns if the elements is empty
     * */
    public boolean isEmpty(){
        return elements.isEmpty();
    }

    /**
     * Evaluate if the Object o is in the JSON
     * @param o The JsonObject.
     * @return Return if true if it contains JsonObject o
     * */
    public boolean contains(JsonObject o){
        return elements.contains(o);
    }

    /**
     * JSON Constructor
     * @return Returns the final JSON.
     * */
    @Override
    public String toJSON() throws ArrayIndexOutOfBoundsException {
        String result = "[";

        for(int i = 0; i < elements.size(); i++){
            JsonObject o = elements.get(i);
            result += o.toJSON();

            if (i != elements.size()-1){
                result += ",";
            }
        }
        result += "]";

        return result;
    }
}
