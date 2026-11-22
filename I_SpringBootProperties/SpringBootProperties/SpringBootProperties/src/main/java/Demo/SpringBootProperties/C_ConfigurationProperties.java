package Demo.SpringBootProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "b-paymentgateway-though-configurationproperties")
public class C_ConfigurationProperties {
    private String type;
    private int retryCount;
    private String collegeName;
    private long rollnumber;
    private String district;
    private String village;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getRetryCount() { return retryCount; }
    public void setRetryCount(int retryCount) { this.retryCount = retryCount; }
    public String getCollegeName() { return collegeName; }
    public void setCollegeName(String collegeName) { this.collegeName = collegeName; }
    public long getRollnumber() { return rollnumber; }
    public void setRollnumber(long rollnumber) { this.rollnumber = rollnumber; }
    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }
    public String getVillage() { return village; }
    public void setVillage(String village) { this.village = village; }
}
