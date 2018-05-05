package splyzeservices;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;

@ManagedBean(name="backing_splyzeadmin")
@RequestScoped
public class SplyzeAdmin {
    private HtmlInputText inputText1;
    private HtmlOutputText outputText1;
    private HtmlInputText inputText2;
    private HtmlOutputText outputText2;
    private HtmlInputText inputText3;
    private HtmlOutputText outputText3;
    private HtmlInputText inputText4;
    private HtmlOutputText outputText4;
    private HtmlInputText inputText5;
    private HtmlOutputText outputText5;
    private HtmlInputText inputText6;
    private HtmlOutputText outputText6;
    private HtmlInputText inputText7;
    private HtmlOutputText outputText7;
    private HtmlForm form1;
    private HtmlOutputText outputText8;
    private HtmlCommandButton registerEvent;
    private HtmlCommandButton registerLocation;

    public SplyzeAdmin() {
    }


    public Object registerEvent_action() {
        // Add event code here...
        return "registerEvent";
    }

    public Object registerLocation_action() {
        // Add event code here...
        return "registerLocation";
    }

    public void setInputText1(HtmlInputText inputText1) {
        this.inputText1 = inputText1;
    }

    public HtmlInputText getInputText1() {
        return inputText1;
    }

    public void setOutputText1(HtmlOutputText outputText1) {
        this.outputText1 = outputText1;
    }

    public HtmlOutputText getOutputText1() {
        return outputText1;
    }

    public void setInputText2(HtmlInputText inputText2) {
        this.inputText2 = inputText2;
    }

    public HtmlInputText getInputText2() {
        return inputText2;
    }

    public void setOutputText2(HtmlOutputText outputText2) {
        this.outputText2 = outputText2;
    }

    public HtmlOutputText getOutputText2() {
        return outputText2;
    }

    public void setInputText3(HtmlInputText inputText3) {
        this.inputText3 = inputText3;
    }

    public HtmlInputText getInputText3() {
        return inputText3;
    }

    public void setOutputText3(HtmlOutputText outputText3) {
        this.outputText3 = outputText3;
    }

    public HtmlOutputText getOutputText3() {
        return outputText3;
    }

    public void setInputText4(HtmlInputText inputText4) {
        this.inputText4 = inputText4;
    }

    public HtmlInputText getInputText4() {
        return inputText4;
    }

    public void setOutputText4(HtmlOutputText outputText4) {
        this.outputText4 = outputText4;
    }

    public HtmlOutputText getOutputText4() {
        return outputText4;
    }

    public void setInputText5(HtmlInputText inputText5) {
        this.inputText5 = inputText5;
    }

    public HtmlInputText getInputText5() {
        return inputText5;
    }

    public void setOutputText5(HtmlOutputText outputText5) {
        this.outputText5 = outputText5;
    }

    public HtmlOutputText getOutputText5() {
        return outputText5;
    }

    public void setInputText6(HtmlInputText inputText6) {
        this.inputText6 = inputText6;
    }

    public HtmlInputText getInputText6() {
        return inputText6;
    }

    public void setOutputText6(HtmlOutputText outputText6) {
        this.outputText6 = outputText6;
    }

    public HtmlOutputText getOutputText6() {
        return outputText6;
    }

    public void setInputText7(HtmlInputText inputText7) {
        this.inputText7 = inputText7;
    }

    public HtmlInputText getInputText7() {
        return inputText7;
    }

    public void setOutputText7(HtmlOutputText outputText7) {
        this.outputText7 = outputText7;
    }

    public HtmlOutputText getOutputText7() {
        return outputText7;
    }


    public void setOutputText8(HtmlOutputText outputText8) {
        this.outputText8 = outputText8;
    }

    public HtmlOutputText getOutputText8() {
        return outputText8;
    }

    public void setForm1(HtmlForm form1) {
        this.form1 = form1;
    }

    public HtmlForm getForm1() {
        return form1;
    }

    public void setRegisterEvent(HtmlCommandButton registerEvent) {
        this.registerEvent = registerEvent;
    }

    public HtmlCommandButton getRegisterEvent() {
        return registerEvent;
    }

    public void setRegisterLocation(HtmlCommandButton registerLocation) {
        this.registerLocation = registerLocation;
    }

    public HtmlCommandButton getRegisterLocation() {
        return registerLocation;
    }
}
