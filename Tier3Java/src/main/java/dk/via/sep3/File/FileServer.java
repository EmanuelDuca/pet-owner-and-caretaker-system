//package dk.via.sep3.File;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import dk.via.sep3.shared.AnnouncementEntity;
//import dk.via.sep3.shared.PetOwnerEntity;
//
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class FileServer {
//    private ObjectMapper json;
//    private final String filepath = "DatabaseList.bin";
//
//    private static FileServer obj;
//    private ArrayList<PetOwnerEntity> petOwnersList;
//    private ArrayList<AnnouncementEntity> announcementsList;
//
//
//    private FileServer() {
//        json = new ObjectMapper();
//        petOwnersList = new ArrayList<>();
//        announcementsList = new ArrayList<>();
//    }
//
//    public static FileServer getInstance() {
//        if (obj == null) {
//            obj = new FileServer();
//        }
//        return obj;
//    }
//
//    public void AppendToFile(PetOwnerEntity petOwner) {
//        petOwnersList.add(petOwner);
//        writeDatabaseToFile();
//    }
//
//    public void AppendToFile(AnnouncementEntity announcement) {
//        announcementsList.add(announcement);
//        writeDatabaseToFile();
//    }
//
//    public ArrayList<AnnouncementEntity> getAnnouncement(){
//        readFromDatabase();
//        return announcementsList;
//    }
//
//    public ArrayList<PetOwnerEntity> getPetOwners(){
//        readFromDatabase();
//        return petOwnersList;
//    }
//
//
//
//    private String convertToString(Object obj){
//        try{
//            return json.writeValueAsString(obj);
//        }catch (Exception e){
//            System.err.println(e.getMessage());
//        }
//        return null;
//    }
//
//    private ArrayList<AnnouncementEntity> fetchAnnouncementList(){
//        return announcementsList;
//    }
//
//    private ArrayList<PetOwnerEntity> fetchPetOwnerList(){
//        return petOwnersList;
//    }
//
//    private void  writeDatabaseToFile(){
//        try {
//            MyFileHandler.writeToBinaryFile(filepath, this);
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        } catch (IOException e) {
//            System.out.println("IO Error writing to file");
//        }
//    }
//
//    private void readFromDatabase(){
//        FileServer fileServer ;
//        try{
//            fileServer = (FileServer) MyFileHandler.readFromBinaryFile(filepath);
//            announcementsList = fileServer.fetchAnnouncementList();
//            petOwnersList = fileServer.fetchPetOwnerList();
//        }
//        catch (FileNotFoundException e)
//        {
//            System.out.println("File not found");
//        }
//        catch (IOException e)
//        {
//            System.out.println("IO Error reading file");
//        }
//        catch (ClassNotFoundException e)
//        {
//            System.out.println("Class Not Found");
//        }
//    }
//
//
//
//
//}
