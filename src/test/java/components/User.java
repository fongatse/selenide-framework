package components;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.google.gson.JsonObject;

/**
 * This class defines the user parameters
 */
public class User {
    private final String jsonPath;
    private final String email;
    private String password;
    private String oldPassword;
    private FileReader filereader;
    private BufferedWriter writer;
    private File jsonFile;
    JSONObject jsonObject;

    /**
     * This constructor parses a JSON file and assigns the data from the file to the
     * local variables
     *
     * @param path path to JSON data file containing the user email and password
     * @throws IOException
     * @throws ParseException
     */
    public User(final String path) throws IOException, ParseException {
        this.jsonPath = path;
        final JSONParser jsonparser = new JSONParser();
        filereader = new FileReader(jsonPath);
        jsonObject = (JSONObject) jsonparser.parse(filereader);

        this.email = this.jsonObject.get("email").toString();
        this.password = this.jsonObject.get("password").toString();
    }

    public String getOldPassword() {
        return oldPassword;
    }

    private void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public void softChangePassword(String password) {
        jsonObject.remove("password");
        jsonObject.put("password", password);
        setOldPassword(this.password);
        this.password = password;

    }

    public void permanentChangePassword(String password) {
        jsonObject.remove("password");
        jsonObject.put("password", password);
        jsonFile = new File(jsonPath);

        String json = jsonObject.toString();

        try {
            jsonFile.createNewFile();
            writer = new BufferedWriter(new FileWriter(jsonPath));
            writer.flush();
            writer.write(json);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            setOldPassword(this.password);
            this.password = password;
        }

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
