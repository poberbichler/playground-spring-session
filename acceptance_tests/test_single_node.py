from acceptance_tests.home_requests import HomeRequests


def test_session_ids_not_equal_for_two_initial_requests():
    r1 = HomeRequests("http://localhost:8050")
    r2 = HomeRequests("http://localhost:8050")
    assert r1.extract_session_id() != r2.extract_session_id()


def test_session_ids_are_equal_with_same_cookie():
    r = HomeRequests("http://localhost:8050")
    assert r.extract_session_id() == r.extract_session_id()
