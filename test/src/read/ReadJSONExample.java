package read;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import biblioteca.Atalho;
import conexao.ControlePorta;
 
public class ReadJSONExample {
	
 
	 Atalho atalho = new Atalho();
	 
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("data.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray PersonList = (JSONArray) obj;
            System.out.println(PersonList);
             
            //Iterate over Person array
            PersonList.forEach( per -> parsePersonObject( (JSONObject) per ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    private static void parsePersonObject(JSONObject person)
    {
 	   	Atalho atalho = new Atalho();

        JSONObject PersonObject = (JSONObject) person.get("Person");
         
        //Get Person first name
        atalho.setNome((String) PersonObject.get("nome"));
        System.out.println(atalho.getNome());
         
        //Get Person last name
        atalho.setSobrenome((String) PersonObject.get("sobrenome"));
        System.out.println(atalho.getSobrenome());
        }
    }





