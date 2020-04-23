package components;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * This class defines the user parameters
 */
public class User {
    private String jsonPath;
    private String email;
    private String password;

    /**
     * This constructor parses a JSON file and assigns the data from the file to the local variables
     *
     * @param path path to JSON data file containing the user email and password
     * @throws IOException
     * @throws ParseException
     */
    public User(String path) throws IOException, ParseException {
        this.jsonPath = path;
        JSONParser jsonparser = new JSONParser();
        FileReader filereader = new FileReader(jsonPath);

        JSONObject jsonobject = (JSONObject) jsonparser.parse(filereader);
        this.email = jsonobject.get("email").toString();
        this.password = jsonobject.get("password").toString();
    }

    private void setJsonPath(String path) {
        this.jsonPath = path;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
