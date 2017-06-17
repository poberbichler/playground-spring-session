import requests
from bs4 import BeautifulSoup

def test_session_ids_not_equal_for_two_initial_requests():
    first_id = _extract_session_id()
    second_id = _extract_session_id()

    assert first_id != second_id


def test_session_ids_are_equal_with_same_cookie():
    cookie = _extract_cookie()
    first_id = _extract_session_id(cookie)
    second_id = _extract_session_id(cookie)

    assert first_id == second_id


def _extract_session_id(cookie = {}):
    print(f"cookie to be used: {cookie}")
    r = requests.get("http://localhost:8050", cookies=cookie)
    bs = BeautifulSoup(r.text, "html.parser")
    return bs.find(id="sessionId").text


def _extract_cookie():
    r = requests.get("http://localhost:8050")
    return r.cookies

