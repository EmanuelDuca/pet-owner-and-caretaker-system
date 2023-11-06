package origin.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import origin.shared.AnnouncementEntity;
import origin.shared.UserEntity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class FileServer implements Serializable
{
    private ObjectMapper json;
    private final String filepath = "../001_JavaServer/DatabaseList.bin";

    private static FileServer obj;
    private ArrayList<UserEntity> userList;
    private ArrayList<AnnouncementEntity> announcementsList;


    private FileServer() {
        json = new ObjectMapper();
        userList = new ArrayList<>();
        announcementsList = new ArrayList<>();
    }

    public static FileServer getInstance() {
        if (obj == null) {
            obj = new FileServer();
        }
        return obj;
    }

    public void AppendToFile(UserEntity petOwner) {
        userList.add(petOwner);
        writeDatabaseToFile();
    }

    public void AppendToFile(AnnouncementEntity announcement) {
        announcementsList.add(announcement);
        writeDatabaseToFile();
    }

    public ArrayList<AnnouncementEntity> getAnnouncements(){
        readFromDatabase();
        return announcementsList;
    }

    public ArrayList<UserEntity> getUsers(){
        readFromDatabase();
        return userList;
    }



    private String convertToString(Object obj){
        try{
            return json.writeValueAsString(obj);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    private ArrayList<AnnouncementEntity> fetchAnnouncementList(){
        return announcementsList;
    }

    private ArrayList<UserEntity> fetchUserList(){
        return userList;
    }

    private void writeDatabaseToFile(){
        try {
            MyFileHandler.writeToBinaryFile(filepath,this);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Error writing to file");
        }
    }

    private void readFromDatabase(){
        FileServer fileServer;
        try{
            fileServer = (FileServer) MyFileHandler.readFromBinaryFile(filepath);
            announcementsList = fileServer.fetchAnnouncementList();
            userList = fileServer.fetchUserList();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("IO Error reading file");
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }




}
