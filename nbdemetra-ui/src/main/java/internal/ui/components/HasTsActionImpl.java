/*
 * Copyright 2018 National Bank of Belgium
 * 
 * Licensed under the EUPL, Version 1.1 or - as soon they will be approved 
 * by the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 * 
 * http://ec.europa.eu/idabc/eupl
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and 
 * limitations under the Licence.
 */
package internal.ui.components;

import demetra.ui.beans.PropertyChangeSource;
import demetra.ui.components.HasTsAction;
import ec.nbdemetra.ui.tsaction.ITsAction;

/**
 *
 * @author Philippe Charles
 */
@lombok.RequiredArgsConstructor
public final class HasTsActionImpl implements HasTsAction {

    @lombok.NonNull
    private final PropertyChangeSource.Broadcaster broadcaster;
    private ITsAction tsAction = null;

    @Override
    public void setTsAction(ITsAction tsAction) {
        ITsAction old = this.tsAction;
        this.tsAction = tsAction;
        broadcaster.firePropertyChange(TS_ACTION_PROPERTY, old, this.tsAction);
    }

    @Override
    public ITsAction getTsAction() {
        return tsAction;
    }
}