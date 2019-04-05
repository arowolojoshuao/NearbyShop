package ng.com.silveredgeprojects.mmo.utilities.helper;

/**
 * Created by SilverEdgeProjects-O on 10/26/2017.
 */

public class Enums {

    public enum FileStatusEnum {
        InCabinet("In cabinet"),
        OnAJourney("On a journey"),
        FileRetrieved("Retrieved"),
        FileDispatched("Dispatched"),
        FileAcknowledged("Acknowledged");

        private String description;

        FileStatusEnum(String s) {
            this.description = s;
        }

        public String getDescription() {
            return description;
        }

        public int getIndex() {
            return ordinal() + 1;
        }
    }
    public enum RequestStatusEnum {
        Pending,
        Dispatched,
        Received,
        KeptInView,
        Returned;

        public int getIndex() {
            return ordinal() + 1;
        }
    }

    public enum Roles {
        User("User"),
        SuperAdmin("Super Admin"),
        DispatchUser("Dispatch User"),
        DispatchAdminUser("Dispatch Admin User"),
        AuditUser("Audit User");

        private String description;

        Roles(String s) {
            this.description = s;
        }

        public String getDescription() {
            return description;
        }

        public int getIndex() {
            return ordinal() + 1;
        }
    }

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          