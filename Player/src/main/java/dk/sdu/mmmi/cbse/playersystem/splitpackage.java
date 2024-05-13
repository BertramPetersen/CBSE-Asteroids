package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.services.ISplitPackages;

public class splitpackage implements ISplitPackages {
    @Override
    public String splitPackage() {
       return "I am a split package from player module";
    }
}
