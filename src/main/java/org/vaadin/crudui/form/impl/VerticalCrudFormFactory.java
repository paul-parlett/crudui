package org.vaadin.crudui.form.impl;

import com.vaadin.data.HasValue;
import com.vaadin.ui.*;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.form.AbstractAutoGeneratedCrudFormFactory;

import java.util.List;

/**
 * @author Alejandro Duarte
 */
public class VerticalCrudFormFactory<T> extends AbstractAutoGeneratedCrudFormFactory<T> {

    public VerticalCrudFormFactory(Class<T> domainType) {
        super(domainType);
    }

    @Override
    public Component buildNewForm(CrudOperation operation, T domainObject, boolean readOnly, Button.ClickListener cancelButtonClickListener, Button.ClickListener operationButtonClickListener) {
        FormLayout formLayout = new FormLayout();

        List<HasValue> fields = buildAndBind(operation, domainObject, readOnly);
        fields.stream().forEach(field -> formLayout.addComponent((Component) field));

        Layout footerLayout = buildFooter(operation, domainObject, cancelButtonClickListener, operationButtonClickListener);

        VerticalLayout mainLayout = new VerticalLayout(formLayout, footerLayout);
        mainLayout.setComponentAlignment(footerLayout, Alignment.BOTTOM_RIGHT);
        mainLayout.setMargin(true);

        return mainLayout;
    }

}
