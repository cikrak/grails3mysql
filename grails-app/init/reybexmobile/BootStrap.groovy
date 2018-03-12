package reybexmobile

import com.editsystems.Role
import com.editsystems.User
import com.editsystems.UserRole

class BootStrap {

    def init = { servletContext ->
        User U1 = new User(username: "admin", password: "admin", enabled: true, type: "ADMIN").save()
        User U2 = new User(username: "normal", password: "normal", enabled: true, type: "NORMAL").save()

        Role R1 = new Role(authority: "ROLE_ADMIN").save()
        Role R2 = new Role(authority: "ROLE_NORMAL").save()

        UserRole.create(U1, R1)
        UserRole.create(U1, R2)

        UserRole.create(U2, R2)
    }
    def destroy = {
    }
}
