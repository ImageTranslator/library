package com.library



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LibarianController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Libarian.list(params), model:[libarianInstanceCount: Libarian.count()]
    }

    def show(Libarian libarianInstance) {
        respond libarianInstance
    }

    def create() {
        respond new Libarian(params)
    }

    @Transactional
    def save(Libarian libarianInstance) {
        if (libarianInstance == null) {
            notFound()
            return
        }

        if (libarianInstance.hasErrors()) {
            respond libarianInstance.errors, view:'create'
            return
        }

        libarianInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'libarian.label', default: 'Libarian'), libarianInstance.id])
                redirect libarianInstance
            }
            '*' { respond libarianInstance, [status: CREATED] }
        }
    }

    def edit(Libarian libarianInstance) {
        respond libarianInstance
    }

    @Transactional
    def update(Libarian libarianInstance) {
        if (libarianInstance == null) {
            notFound()
            return
        }

        if (libarianInstance.hasErrors()) {
            respond libarianInstance.errors, view:'edit'
            return
        }

        libarianInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Libarian.label', default: 'Libarian'), libarianInstance.id])
                redirect libarianInstance
            }
            '*'{ respond libarianInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Libarian libarianInstance) {

        if (libarianInstance == null) {
            notFound()
            return
        }

        libarianInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Libarian.label', default: 'Libarian'), libarianInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

def login() {
 if (params.cName)
 return [cName:params.cName, aName:params.aName]
 }

def logout = {
 session.user = null
 redirect(uri:'/')
 }


def validate() {
 def user = Libarian.findByUserName(params.userName)
 if (user && user.password == params.password){
 session.user = user
 if (params.cName)
 redirect controller:params.cName, action:params.aName
 else
 redirect controller:'course', action:'index'
 } else{
 flash.message = "Invalid username and password."
 render view:'login'
 }
 }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'libarian.label', default: 'Libarian'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
