package write;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
public class WriteJSONExample
{
    @SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
        //First Person
        JSONObject PersonDetails= new JSONObject();
        PersonDetails.put("nome", "Aaaaa");
        PersonDetails.put("sobrenome", "Bbbbb");
         
        JSONObject PersonObject = new JSONObject();
        PersonObject.put("Person", PersonDetails);
        

        //Add Person to list
        JSONArray PersonList = new JSONArray();
        PersonList.add(PersonObject);

         
        //Write JSON file
        try (FileWriter file = new FileWriter("data.json")) {
 
            file.write(PersonList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
			e.printStackTrace();
		}
    }
}