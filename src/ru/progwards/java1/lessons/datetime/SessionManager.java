package ru.progwards.java1.lessons.datetime;

import java.time.LocalDateTime;
import java.util.*;

class UserSession {
    static private int handleNextNum = 0;
    private int sessionHanle;
    private String userName;
    private LocalDateTime lastAccess;
    private SessionManager sessionManager;

    // создать сессию пользователя
    UserSession(String userName) {
        Random rnd = new Random();
        this.sessionHanle = handleNextNum++;
        this.userName = userName;
        refreshLastAccess();
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void setSessionHandle(int sessionHanle) {
        sessionManager.reHash(this, this.sessionHanle, sessionHanle);
        this.sessionHanle = sessionHanle;
    }

    public int getSessionHandle() {
        return sessionHanle;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void refreshLastAccess() {
        this.lastAccess = LocalDateTime.now();
    }

    public void setLastAccess(LocalDateTime lastAccess) {
        this.lastAccess = lastAccess;
    }

    public LocalDateTime getLastAccess() {
        return lastAccess;
    }

    public boolean isValid(int sessionValid, LocalDateTime now) {
        return lastAccess.plusSeconds(sessionValid).isAfter(now);
    }

    @Override
    public String toString() {
        return "S{" + "h=" + sessionHanle + ",u='" + userName + '}';
    }
}

public class SessionManager {
    List<UserSession> sessions; // список сессий пользователей по sessionHanle (т.к. есть setSessionHanle, нет гарантий, что не изменят его)
    Hashtable<Integer, UserSession> hashSessions; // поиск сессии по sessionHanle

    int sessionValid; // период валидности сессии в секундах

    SessionManager(int sessionValid) {
        sessions = new ArrayList<UserSession>();
        hashSessions = new Hashtable<Integer, UserSession>();
        this.sessionValid = sessionValid;
    }

    // добавляет новую сессию пользователя
    public void add(UserSession userSession) {
        if (get(userSession.getSessionHandle()) != null) return; // лучше бы метод add возвращал true/false
        userSession.setSessionManager(this);
        sessions.add(userSession);
        hashSessions.put(userSession.getSessionHandle(), userSession);
    }

    // проверяет наличие существующей сессии по userName. Если срок валидности истек, или такой нет, возвращает null
    public UserSession find(String userName) {
        LocalDateTime now = LocalDateTime.now();
        for (UserSession s : sessions) {
            if (s.getUserName() == userName) {
                if (s.isValid(sessionValid, now)) return s;
            }
        }
        return null;
    }

    // проверяет наличие существующей сессии по хендлу. Если срок валидности истек, или такой нет, возвращает null
    public UserSession get(int sessionHandle) {
        UserSession s = hashSessions.get(sessionHandle);
        if (s != null && s.isValid(sessionValid, LocalDateTime.now())) {
            s.refreshLastAccess();
            return s;
        } else {
            return null;
        }
    }

    // удаляет указанную сессию пользователя
    public void delete(int sessionHandle) {
        UserSession userSession = hashSessions.get(sessionHandle);
        if (userSession != null) {
            hashSessions.remove(sessionHandle);
            sessions.remove(userSession);
        }
    }

    // удаляет все сессии с истекшим сроком годности.
    public void deleteExpired() {
        LocalDateTime now = LocalDateTime.now();
        Iterator i = sessions.listIterator();
        while (i.hasNext()) {
            UserSession s = (UserSession) i.next();
            if (!s.isValid(sessionValid, now)) {
                hashSessions.remove(s.getSessionHandle());
                i.remove();
            }
        }
    }

    // проиводим обновление hash сесии пользователя
    protected void reHash(UserSession userSession, int oldHash, int newHash) {
        hashSessions.remove(oldHash);
        hashSessions.put(newHash, userSession);
    }

    @Override
    public String toString() {
        return "Manager{" + sessions + '}';
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
        }
    }

    public static void main(String[] args) {

    }
}
