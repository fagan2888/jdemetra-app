/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.nbdemetra.ui.calendars;

import ec.nbdemetra.ws.WorkspaceFactory;
import ec.nbdemetra.ws.WorkspaceItem;
import ec.tstoolkit.timeseries.calendars.GregorianCalendarManager;
import ec.tstoolkit.timeseries.calendars.IGregorianCalendarProvider;
import java.awt.BorderLayout;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//ec.nbdemetra.ui.calendars//Calendar//EN",
autostore = false)
@TopComponent.Description(preferredID = "CalendarTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_NEVER)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "ec.nbdemetra.ui.calendars.CalendarTopComponent")
@TopComponent.OpenActionRegistration(displayName = "#CTL_CalendarAction",
preferredID = "CalendarTopComponent")
@Messages({
    "CTL_CalendarAction=Calendar",
    "CTL_CalendarTopComponent=Calendar Window",
    "HINT_CalendarTopComponent=This is a Calendar window"
})
public final class CalendarTopComponent extends TopComponent {

    private final WorkspaceItem<IGregorianCalendarProvider> calendar;

    public CalendarTopComponent() {
        this((WorkspaceItem<IGregorianCalendarProvider>) WorkspaceFactory.getInstance().getActiveWorkspace().
                searchDocument(CalendarDocumentManager.ID, GregorianCalendarManager.DEF));
    }

    public CalendarTopComponent(WorkspaceItem<IGregorianCalendarProvider> calendar) {
        this.calendar = calendar;
        initComponents();
        setName(calendar.getId().toString());
        setDisplayName(calendar.getDisplayName());
        setToolTipText(Bundle.HINT_CalendarTopComponent());
        CalendarView view = new CalendarView();
        view.setCalendarProvider(calendar.getElement());
        add(view, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
         calendar.setView(this);
       // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        calendar.setView(null);
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
