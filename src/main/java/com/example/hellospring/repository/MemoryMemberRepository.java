package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;
import java.util.*;
public class MemoryMemberRepository implements MemberRepository{
    private Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        // ID 지정 및 해당 맴버 Store에 저장
        member.setId(sequence++);
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Member> findByName(String name) {
        // Optional.ofNullable(store.get(name))
        // 해당 내용이 잘 이해가지 않지만, 그냥 작성
        return  store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    public void clearStore() {
        store.clear();
    }
}
