package hermes.ejb.controller.bugreport;

import hermes.ejb.entidades.BugReport;
import hermes.ejb.entidades.Cliente;
import hermes.ejb.utils.Persist;
import javax.ejb.Stateless;

/**
 *
 * @author iuryk
 */
@Stateless(mappedName = "ejb/controlaBugReport/ControlaBugreport")
public class BugReportController extends Persist implements BugReportRemote{
    
    @Override
    public BugReport cadastraBugReport(BugReport bugReport) {
        try {
            BugReport b;
            b = (BugReport) inserirObjeto(bugReport);
            return b;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }
    }
}
