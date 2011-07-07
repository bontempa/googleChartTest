package googlecharttest



import org.junit.*
import grails.test.mixin.*


@TestFor(AlexNumController)
@Mock(AlexNum)
class AlexNumControllerTests {


    @Test
    void testIndex() {
        controller.index()
        assert "/alexNum/list" == response.redirectedUrl
    }

    @Test
    void testList() {

        def model = controller.list()

        assert model.alexNumInstanceList.size() == 0
        assert model.alexNumInstanceTotal == 0

    }

    @Test
    void testCreate() {
        def model = controller.create()

        assert model.alexNumInstance != null


    }

    @Test
    void testSave() {
        controller.save()

        assert model.alexNumInstance != null
        assert view == '/alexNum/create'

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/alexNum/show/1'
        assert controller.flash.message != null
        assert AlexNum.count() == 1
    }


    @Test
    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/alexNum/list'


        def alexNum = new AlexNum()

        // TODO: populate domain properties

        assert alexNum.save() != null

        params.id = alexNum.id

        def model = controller.show()

        assert model.alexNumInstance == alexNum
    }

    @Test
    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/alexNum/list'


        def alexNum = new AlexNum()

        // TODO: populate valid domain properties

        assert alexNum.save() != null

        params.id = alexNum.id

        def model = controller.edit()

        assert model.alexNumInstance == alexNum
    }

    @Test
    void testUpdate() {

        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/alexNum/list'

        response.reset()


        def alexNum = new AlexNum()

        // TODO: populate valid domain properties

        assert alexNum.save() != null

        // test invalid parameters in update
        params.id = alexNum.id

        controller.update()

        assert view == "/alexNum/edit"
        assert model.alexNumInstance != null

        alexNum.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/alexNum/show/$alexNum.id"
        assert flash.message != null
    }

    @Test
    void testDelete() {
        controller.delete()

        assert flash.message != null
        assert response.redirectedUrl == '/alexNum/list'

        response.reset()

        def alexNum = new AlexNum()

        // TODO: populate valid domain properties
        assert alexNum.save() != null
        assert AlexNum.count() == 1

        params.id = alexNum.id

        controller.delete()

        assert AlexNum.count() == 0
        assert AlexNum.get(alexNum.id) == null
        assert response.redirectedUrl == '/alexNum/list'


    }


}