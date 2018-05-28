/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ui.view.tsprocessing;

import demetra.bridge.TsConverter;
import demetra.ui.TsManager;
import demetra.ui.components.HasTsCollection.TsUpdateMode;
import ec.tss.TsCollection;
import ec.tss.documents.DocumentManager;
import ec.tss.documents.TsDocument;
import demetra.ui.components.JTsChart;

/**
 *
 * @author Jean Palate
 */
public class DualChartUI<D extends TsDocument<?, ?>> extends PooledItemUI<IProcDocumentView<D>, String[][], JTsChart> {

    public DualChartUI() {
        super(JTsChart.class);
    }

    @Override
    protected void init(JTsChart c, IProcDocumentView<D> host, String[][] information) {
        String[] hnames = information[0], lnames = information[1];
        TsCollection items = TsManager.getDefault().newTsCollection();
        if (hnames != null) {
            for (int i = 0; i < hnames.length; ++i) {
                items.quietAdd(DocumentManager.instance.getTs(host.getDocument(), hnames[i]));
            }
        }
        if (lnames != null) {
            for (int i = 0; i < lnames.length; ++i) {
                items.quietAdd(DocumentManager.instance.getTs(host.getDocument(), lnames[i]));
            }
        }
        c.setDualChart(true);
        c.setTsCollection(TsConverter.toTsCollection(items));
        c.setTsUpdateMode(TsUpdateMode.None);
        int i = 0;
        c.getDualDispatcher().clearSelection();
        if (hnames != null) {
            for (; i < hnames.length; ++i) {
            }
        }
        if (lnames != null) {
            for (int j = 0; j < lnames.length; ++j, ++i) {
                c.getDualDispatcher().setSelectionInterval(i, i);
            }
        }
    }
}
