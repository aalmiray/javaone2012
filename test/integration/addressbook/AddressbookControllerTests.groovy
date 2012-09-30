package addressbook

import griffon.core.GriffonApplication
import griffon.test.*

class AddressbookControllerTests extends GriffonUnitTestCase {
    GriffonApplication app

    void testSelectedIndexChangeUpdatesModelProperties() {
        def (m, v, c) = app.createMVCGroup('addressbook')
        
        try {
            for (propName in Contact.PROPERTIES) {
                assert !m[propName] 
            }

            m.selectedIndex = 0
            assert m.name == 'Andres'
            assert m.contacts[0].name == m.name
        } finally {
            app.destroyMVCGroup('addressbook')
        }
    }
}
