package org.zyd.store.term;

import org.zyd.store.base.term.BaseTerm;

/**
 * 
 * RightsConfigTerm
 * 
 * @author GeJianKui
 */
public class RightsConfigTerm extends BaseTerm {

    private String rights;
    private String rightsDescription;

    public String getRights() {
        return this.rights;
    }

    public String getRightsDescription() {
        return this.rightsDescription;
    }

    public void setRights(String rights) {
        this.rights = rights == null ? null : rights.trim();
    }

    public void setRightsDescription(String rightsDescription) {
        this.rightsDescription = rightsDescription == null ? null : rightsDescription.trim();
    }

}
