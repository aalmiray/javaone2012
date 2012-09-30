package addressbook

import griffon.spock.*
import griffon.core.GriffonApplication

class AddressbookControllerSpec extends IntegrationSpec {
    GriffonApplication app

    def 'Changing model.selectedIndex should update model properties mirroring Contact'() {
        setup:
            def (m, v, c) = app.createMVCGroup('addressbook')

        expect:
            for (propName in Contact.PROPERTIES) {
                assert !m[propName] 
            }

        when:
            m.selectedIndex = 0

        then:
            m.name == 'Andres'
            m.contacts[0].name == m.name
    }

    def cleanup() {
        app.destroyMVCGroup('addressbook')
    }
}
