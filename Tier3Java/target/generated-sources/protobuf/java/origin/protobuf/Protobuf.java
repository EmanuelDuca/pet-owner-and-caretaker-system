// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protobuf.proto

package origin.protobuf;

public final class Protobuf {
  private Protobuf() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UserProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UserProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UsersProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UsersProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_FindUserProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_FindUserProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SearchUsersProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SearchUsersProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LoginUserProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoginUserProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AnnouncementProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AnnouncementProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AnnouncementsProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AnnouncementsProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_FindAnnouncementProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_FindAnnouncementProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SearchAnnouncementProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SearchAnnouncementProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PetProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PetProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ResponseStatus_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ResponseStatus_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StartCareServiceRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StartCareServiceRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Void_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Void_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016protobuf.proto\032\036google/protobuf/wrappe" +
      "rs.proto\032\037google/protobuf/timestamp.prot" +
      "o\"\317\001\n\tUserProto\022\r\n\005email\030\001 \001(\t\022\020\n\010passwo" +
      "rd\030\002 \001(\t\022\020\n\010username\030\003 \001(\t\022\014\n\004type\030\004 \001(\t" +
      "\022*\n\004name\030\005 \001(\0132\034.google.protobuf.StringV" +
      "alue\022(\n\003age\030\006 \001(\0132\033.google.protobuf.Int3" +
      "2Value\022+\n\005phone\030\007 \001(\0132\034.google.protobuf." +
      "StringValue\"\'\n\nUsersProto\022\031\n\005users\030\001 \003(\013" +
      "2\n.UserProto\"\036\n\rFindUserProto\022\r\n\005email\030\001" +
      " \001(\t\"\224\001\n\020SearchUsersProto\022*\n\004type\030\001 \001(\0132",
      "\034.google.protobuf.StringValue\022*\n\004name\030\002 " +
      "\001(\0132\034.google.protobuf.StringValue\022(\n\003age" +
      "\030\003 \001(\0132\033.google.protobuf.Int32Value\"1\n\016L" +
      "oginUserProto\022\r\n\005email\030\001 \001(\t\022\020\n\010password" +
      "\030\002 \001(\t\"\212\002\n\021AnnouncementProto\022\025\n\rpetOwner" +
      "Email\030\001 \001(\t\022\023\n\013description\030\002 \001(\t\022-\n\ttime" +
      "Start\030\003 \001(\0132\032.google.protobuf.Timestamp\022" +
      ".\n\ntimeFinish\030\004 \001(\0132\032.google.protobuf.Ti" +
      "mestamp\022\026\n\003pet\030\005 \001(\0132\t.PetProto\022\022\n\nposta" +
      "lCode\030\006 \001(\t\0222\n\016dateOfCreation\030\007 \001(\0132\032.go",
      "ogle.protobuf.Timestamp\022\n\n\002id\030\010 \001(\005\"?\n\022A" +
      "nnouncementsProto\022)\n\rannouncements\030\001 \003(\013" +
      "2\022.AnnouncementProto\"#\n\025FindAnnouncement" +
      "Proto\022\n\n\002id\030\001 \001(\005\"\366\002\n\027SearchAnnouncement" +
      "Proto\0226\n\020petOwnerUsername\030\001 \001(\0132\034.google" +
      ".protobuf.StringValue\022-\n\ttimeStart\030\002 \001(\013" +
      "2\032.google.protobuf.Timestamp\022.\n\ntimeFini" +
      "sh\030\003 \001(\0132\032.google.protobuf.Timestamp\0220\n\n" +
      "postalCode\030\004 \001(\0132\034.google.protobuf.Strin" +
      "gValue\022-\n\007petType\030\005 \001(\0132\034.google.protobu",
      "f.StringValue\022.\n\tpetWeight\030\006 \001(\0132\033.googl" +
      "e.protobuf.Int32Value\0223\n\017petIsVaccinated" +
      "\030\007 \001(\0132\032.google.protobuf.BoolValue\"\207\001\n\010P" +
      "etProto\022\017\n\007petName\030\001 \001(\t\022\017\n\007petType\030\002 \001(" +
      "\t\022\016\n\006weight\030\003 \001(\005\022\024\n\014isVaccinated\030\004 \001(\010\022" +
      "\023\n\013description\030\005 \001(\t\022\n\n\002id\030\006 \001(\005\022\022\n\nowne" +
      "rEmail\030\007 \001(\t\"(\n\016ResponseStatus\022\026\n\016respon" +
      "seStatus\030\001 \001(\t\"a\n\027StartCareServiceReques" +
      "t\022\026\n\016initiatorEmail\030\001 \001(\t\022\026\n\016announcemen" +
      "tId\030\002 \001(\005\022\026\n\016recipientEmail\030\003 \001(\t\"\006\n\004Voi",
      "d2\204\002\n\013UserService\022$\n\nCreateUser\022\n.UserPr" +
      "oto\032\n.UserProto\022$\n\005LogIn\022\017.LoginUserProt" +
      "o\032\n.UserProto\022&\n\010FindUser\022\016.FindUserProt" +
      "o\032\n.UserProto\022,\n\nSearchUser\022\021.SearchUser" +
      "sProto\032\013.UsersProto\022$\n\nUpdateUser\022\n.User" +
      "Proto\032\n.UserProto\022-\n\nDeleteUser\022\016.FindUs" +
      "erProto\032\017.ResponseStatus2\323\002\n\023Announcemen" +
      "tService\022<\n\022CreateAnnouncement\022\022.Announc" +
      "ementProto\032\022.AnnouncementProto\022B\n\021FindAn" +
      "nouncements\022\030.SearchAnnouncementProto\032\023.",
      "AnnouncementsProto\022=\n\017GetAnnouncement\022\026." +
      "FindAnnouncementProto\032\022.AnnouncementProt" +
      "o\022<\n\022UpdateAnnouncement\022\022.AnnouncementPr" +
      "oto\032\022.AnnouncementProto\022=\n\022DeleteAnnounc" +
      "ement\022\026.FindAnnouncementProto\032\017.Response" +
      "Status2L\n\022CareServiceRequest\0226\n\tOfferCar" +
      "e\022\030.StartCareServiceRequest\032\017.ResponseSt" +
      "atusB\023\n\017origin.protobufP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
          com.google.protobuf.TimestampProto.getDescriptor(),
        }, assigner);
    internal_static_UserProto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_UserProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UserProto_descriptor,
        new java.lang.String[] { "Email", "Password", "Username", "Type", "Name", "Age", "Phone", });
    internal_static_UsersProto_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_UsersProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UsersProto_descriptor,
        new java.lang.String[] { "Users", });
    internal_static_FindUserProto_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_FindUserProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_FindUserProto_descriptor,
        new java.lang.String[] { "Email", });
    internal_static_SearchUsersProto_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_SearchUsersProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SearchUsersProto_descriptor,
        new java.lang.String[] { "Type", "Name", "Age", });
    internal_static_LoginUserProto_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_LoginUserProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LoginUserProto_descriptor,
        new java.lang.String[] { "Email", "Password", });
    internal_static_AnnouncementProto_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_AnnouncementProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AnnouncementProto_descriptor,
        new java.lang.String[] { "PetOwnerEmail", "Description", "TimeStart", "TimeFinish", "Pet", "PostalCode", "DateOfCreation", "Id", });
    internal_static_AnnouncementsProto_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_AnnouncementsProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AnnouncementsProto_descriptor,
        new java.lang.String[] { "Announcements", });
    internal_static_FindAnnouncementProto_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_FindAnnouncementProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_FindAnnouncementProto_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_SearchAnnouncementProto_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_SearchAnnouncementProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SearchAnnouncementProto_descriptor,
        new java.lang.String[] { "PetOwnerUsername", "TimeStart", "TimeFinish", "PostalCode", "PetType", "PetWeight", "PetIsVaccinated", });
    internal_static_PetProto_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_PetProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PetProto_descriptor,
        new java.lang.String[] { "PetName", "PetType", "Weight", "IsVaccinated", "Description", "Id", "OwnerEmail", });
    internal_static_ResponseStatus_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_ResponseStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ResponseStatus_descriptor,
        new java.lang.String[] { "ResponseStatus", });
    internal_static_StartCareServiceRequest_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_StartCareServiceRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StartCareServiceRequest_descriptor,
        new java.lang.String[] { "InitiatorEmail", "AnnouncementId", "RecipientEmail", });
    internal_static_Void_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_Void_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Void_descriptor,
        new java.lang.String[] { });
    com.google.protobuf.WrappersProto.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
