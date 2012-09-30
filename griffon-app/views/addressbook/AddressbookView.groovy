package addressbook

application(title: 'Addressbook',
  pack: true,
  resizable: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    migLayout(layoutConstraints: 'fill')
    scrollPane(constraints: 'west, w 180!', border: titledBorder('Contacts')) {
        list(id: 'contactList')
    }
    panel(constraints: 'center, grow', border: titledBorder(title: 'Contact')) {
        label 'Contact form'
    }
    panel(constraints: 'east, grow', border: titledBorder(title: 'Actions')) {
        migLayout(layoutConstraints: 'fill, wrap')
        label 'Buttons'
    }
}