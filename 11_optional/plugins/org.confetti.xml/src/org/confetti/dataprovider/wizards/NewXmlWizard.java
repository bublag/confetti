package org.confetti.dataprovider.wizards;

import java.util.LinkedList;
import java.util.List;

import org.confetti.core.Day;
import org.confetti.core.Hour;
import org.confetti.dataprovider.xml.XmlDataProvider;
import org.confetti.rcp.ConfettiPlugin;
import org.confetti.xml.FAOException;
import org.confetti.xml.core.DayXml;
import org.confetti.xml.core.DaysXml;
import org.confetti.xml.core.HourXml;
import org.confetti.xml.core.HoursXml;
import org.confetti.xml.core.InstituteXml;
import org.eclipse.jface.wizard.Wizard;

/**
 * @author Gabor Bubla
 */
public class NewXmlWizard extends Wizard {

    private NewXmlWizardModel model;

    public NewXmlWizard(NewXmlWizardModel model) {
        this.model = model;
    }
    
    @Override
    public void addPages() {
        setWindowTitle("New");
        addPage(new SaveFileWizardPage(model));
    }

    @Override
    public boolean performFinish() {
        try {
            InstituteXml instituteXml = new InstituteXml(model.getDp().getName().getValue(), "5.3.23", "generated by confetti");

            List<DayXml> days = new LinkedList<>();
            for (Day day : model.getDp().getDays().getList()) {
                days.add(new DayXml(day.getName().getValue()));
            }
            instituteXml.setDays(new DaysXml(days));

            List<HourXml> hours = new LinkedList<>();
            for (Hour hour : model.getDp().getHours().getList()) {
                hours.add(new HourXml(hour.getName().getValue()));
            }
            instituteXml.setHours(new HoursXml(hours));
            
            XmlDataProvider dp = new XmlDataProvider(instituteXml, model.getFile());
            dp.save();
            
            ConfettiPlugin.getDefault().setDataProvider(dp, dp);
        } catch (FAOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

}