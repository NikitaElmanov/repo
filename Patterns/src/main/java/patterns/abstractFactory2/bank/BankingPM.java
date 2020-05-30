package patterns.abstractFactory2.bank;

import patterns.abstractFactory2.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println(this.getClass().getSimpleName() + " is managing a back project...");
    }
}
