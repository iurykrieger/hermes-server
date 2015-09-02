package hermes.ejb.controller.bugreport;

import hermes.ejb.entidades.BugReport;
import javax.ejb.Remote;

/**
 *
 * @author iuryk
 */
@Remote
public interface BugReportRemote {
    
    public BugReport cadastraBugReport(BugReport bugReport);
}
