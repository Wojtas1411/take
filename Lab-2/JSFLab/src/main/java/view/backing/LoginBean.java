/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author wojtek
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {
    
    private String username;
    private String password;
    
    private HtmlSelectBooleanCheckbox acceptCheckbox;
    private HtmlCommandButton loginButton;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    /**
     * @return login result
     */
    public String login() {
        if (username.equals(password)) {
            return "success";
        } else {
            return "failure";
        }
    }
    
    public void activateButton(ValueChangeEvent e){
        if (acceptCheckbox.isSelected())
            loginButton.setDisabled(false);
        else
            loginButton.setDisabled(true);
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
    }
    
    public String customValidation() {
        FacesContext context = FacesContext.getCurrentInstance();
        String msg = context.getApplication().getResourceBundle(context, "AppMessages").getString("error.message");
        FacesMessage fm = new FacesMessage(msg);
        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
        if( this.username == null || this.password == null) {
            context.addMessage(null, fm);
            return null;
        }
        if( this.username.equals("scott") && this.password.equals("tiger")) {
            context.addMessage(null, fm);
            return null;
        }
        return "success";
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the acceptCheckbox
     */
    public HtmlSelectBooleanCheckbox getAcceptCheckbox() {
        return acceptCheckbox;
    }

    /**
     * @param acceptCheckbox the acceptCheckbox to set
     */
    public void setAcceptCheckbox(HtmlSelectBooleanCheckbox acceptCheckbox) {
        this.acceptCheckbox = acceptCheckbox;
    }

    /**
     * @return the loginButton
     */
    public HtmlCommandButton getLoginButton() {
        return loginButton;
    }

    /**
     * @param loginButton the loginButton to set
     */
    public void setLoginButton(HtmlCommandButton loginButton) {
        this.loginButton = loginButton;
    }
    
}
