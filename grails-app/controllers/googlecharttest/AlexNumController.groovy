package googlecharttest

import grails.converters.JSON

class AlexNumController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)

    def prenomList = []
    def AgeList = []
    def demoList = AlexNum.list(params)
   demoList.each {
        prenomList << it.prenom
       AgeList << it.age
    }
        def prenomListString = prenomList as String[]
        def myDailyActivitiesData=[['Initialsation', 0]]

        for(int i=0; i<AlexNum.count(); i++)
        {
        myDailyActivitiesData.add([prenomListString[i], AgeList[i]]);
        }

        [alexNumInstanceList: AlexNum.list(params), alexNumInstanceTotal: AlexNum.count(), myDailyActivitiesData: myDailyActivitiesData]
    }

    def create = {
        def alexNumInstance = new AlexNum()
        alexNumInstance.properties = params
        return [alexNumInstance: alexNumInstance]
    }

    def save = {
        def alexNumInstance = new AlexNum(params)
        if (alexNumInstance.save(flush: true)) {
            flash.message = message(code: 'default.created.message', args: [message(code: 'alexNum.label', default: 'AlexNum'), alexNumInstance.id])
            redirect(action: "show", id: alexNumInstance.id)
        }
        else {
            render(view: "create", model: [alexNumInstance: alexNumInstance])
        }
    }

    def show = {
        def alexNumInstance = AlexNum.get(params.id)
        if (!alexNumInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'alexNum.label', default: 'AlexNum'), params.id])
            redirect(action: "list")
        }
        else {
            [alexNumInstance: alexNumInstance]
        }
    }

    def edit = {
        def alexNumInstance = AlexNum.get(params.id)
        if (!alexNumInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'alexNum.label', default: 'AlexNum'), params.id])
            redirect(action: "list")
        }
        else {
            return [alexNumInstance: alexNumInstance]
        }
    }

    def update = {
        def alexNumInstance = AlexNum.get(params.id)
        if (alexNumInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (alexNumInstance.version > version) {

                    alexNumInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'alexNum.label', default: 'AlexNum')] as Object[], "Another user has updated this AlexNum while you were editing")
                    render(view: "edit", model: [alexNumInstance: alexNumInstance])
                    return
                }
            }
            alexNumInstance.properties = params
            if (!alexNumInstance.hasErrors() && alexNumInstance.save(flush: true)) {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'alexNum.label', default: 'AlexNum'), alexNumInstance.id])
                redirect(action: "show", id: alexNumInstance.id)
            }
            else {
                render(view: "edit", model: [alexNumInstance: alexNumInstance])
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'alexNum.label', default: 'AlexNum'), params.id])
            redirect(action: "list")
        }
    }

    def delete = {
        def alexNumInstance = AlexNum.get(params.id)
        if (alexNumInstance) {
            try {
                alexNumInstance.delete(flush: true)
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'alexNum.label', default: 'AlexNum'), params.id])
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'alexNum.label', default: 'AlexNum'), params.id])
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'alexNum.label', default: 'AlexNum'), params.id])
            redirect(action: "list")
        }
    }

    def dataTableDataAsJSON = {
    def list = []
    def demoList = AlexNum.list(params)
    response.setHeader("Cache-Control", "no-store")
    demoList.each {
        list << [
                prenom: it.prenom,
                nom: it.nom,
                age: it.age
        ]
    }
    def data = [
            totalRecords: AlexNum.count(),
            results: list
    ]
    render data as JSON
}


    def render = {
        def myDailyActivitiesData = [['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]]
        render template: "chart", model: ["myDailyActivitiesData1": myDailyActivitiesData]
    }



}
