package addressbook

application(title: app.getMessage('application.title'),
  pack: true,
  resizable: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    menuBar {
        menu(app.getMessage('contacts.label')) {
            menuItem(newAction)
            menuItem(saveAction)
            menuItem(deleteAction)
            menuItem(dumpAction)
        }
    }
    migLayout(layoutConstraints: 'fill')
    scrollPane(constraints: 'west, w 180!', border: titledBorder(app.getMessage('contacts.label'))) {
        list(id: 'contactList', model: eventListModel(source: model.contacts))
    }
    panel(constraints: 'center, grow', border: titledBorder(title: app.getMessage('contact.label'))) {
        migLayout(layoutConstraints: 'fill')
        for (propName in Contact.PROPERTIES) {
            String key = "addressbook.Contact.${propName}.label"
            label(text: app.getMessage(key, GriffonNameUtils.getNaturalName(propName)) + ':', constraints: 'right')
            textField(columns: 30, constraints: 'grow, wrap', name: "${propName}TextField",
                text: bind(propName, source: model, mutual: true))
        }
    }
    panel(constraints: 'east, grow', border: titledBorder(title: app.getMessage('actions.label'))) {
        migLayout(layoutConstraints: 'fill, wrap')
        button(newAction)
        button(saveAction)
        button(deleteAction)
        button(dumpAction)
    }
}