package com.library



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LeaderController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Libarian.list(params), model:[leaderInstanceCount: Libarian.count()]
    }

    def show(Libarian leaderInstance) {
        respond leaderInstance
    }

    def create() {
        respond new Libarian(params)
    }

    @Transactional
    def save(Libarian leaderInstance) {
        if (leaderInstance == null) {
            notFound()
            return
        }

        if (leaderInstance.hasErrors()) {
            respond leaderInstance.errors, view:'create'
            return
        }

        leaderInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'libarian.label', default: 'Libarian'), leaderInstance.id])
                redirect leaderInstance
            }
            '*' { respond leaderInstance, [status: CREATED] }
        }
    }

    def edit(Libarian leaderInstance) {
        respond leaderInstance
    }

    @Transactional
    def update(Libarian leaderInstance) {
        if (leaderInstance == null) {
            notFound()
            return
        }

        if (leaderInstance.hasErrors()) {
            respond leaderInstance.errors, view:'edit'
            return
        }

        leaderInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Libarian.label', default: 'Libarian'), leaderInstance.id])
                redirect leaderInstance
            }
            '*'{ respond leaderInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Libarian leaderInstance) {

        if (leaderInstance == null) {
            notFound()
            return
        }

        leaderInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Libarian.label', default: 'Libarian'), leaderInstance.id])
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
 def user = Libarian.findByUserName(params.username)

 if (user && user.password == params.password){
 
session.user = user

 if (params.cName)
 
redirect controller:params.cName, action:params.aName
 
else
 
redirect controller:'libarian', action:'index'
 }

else{
 
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
