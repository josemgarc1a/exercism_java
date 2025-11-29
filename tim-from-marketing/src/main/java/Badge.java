import java.util.Objects;

class Badge {

    public static final String SPACER = " - ";

    public String print(Integer id, String name, String department) {
        String idText = Objects.isNull(id) ? "" : getId(id);
        String nameText = name + SPACER;
        String departmentText = Objects.isNull(department) ? "OWNER" : department.toUpperCase();
        return idText+nameText+departmentText;
    }

    private String getId(Integer id) {
        return "["+id.toString()+"]"+SPACER;
    }
}
