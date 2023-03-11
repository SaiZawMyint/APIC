package com.itech.desktopfx.persistences.preferences;
import java.util.prefs.Preferences;
public class User {
    private String employeeId;
    private String employeeName;
    private Integer employeeType;
    private String token;
    private Long expires;
    private static final Preferences preferences = Preferences.userRoot().node(User.class.getName());

    public String getEmployeeId() {
        return preferences.get("employeeId", this.employeeId);
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        preferences.put("employeeId", employeeId);
    }

    public String getEmployeeName() {
        return preferences.get("employeeName", this.employeeName);
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        preferences.put("employeeName", employeeName);
    }

    public Integer getEmployeeType() {
        return Integer.parseInt(preferences.get("employeeType", String.valueOf(this.employeeType)));
    }

    public void setEmployeeType(Integer employeeType) {
        this.employeeType = employeeType;
        preferences.put("employeeType", String.valueOf(employeeType));
    }

    public String getToken() {
        return preferences.get("token", (this.token));
    }

    public void setToken(String token) {
        this.token = token;
        preferences.put("token", token);
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }
}
