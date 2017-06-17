from acceptance_tests.home_requests import HomeRequests


def test_intial_port_should_stay_the_same():
    r = HomeRequests("http://localhost:8050")

    assert r.extract_session_id() == r.extract_session_id()
    assert r.extract_initial_port() == r.extract_initial_port()
    assert r.extract_port() != r.extract_port()


def test_session_ids_should_change():
    r1 = HomeRequests("http://localhost:8050")
    r2 = HomeRequests("http://localhost:8050")

    assert r1.extract_session_id() != r2.extract_session_id()
