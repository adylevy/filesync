package FileSync.ServerData.DataTypes;

        import javax.xml.bind.annotation.XmlAccessType;
        import javax.xml.bind.annotation.XmlAccessorType;
        import javax.xml.bind.annotation.XmlAttribute;
        import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class MyJaxbBean
{
    @XmlElement
    public String name;

    @XmlAttribute
    public int age;

    public MyJaxbBean()
    {
    } // JAXB needs this


}