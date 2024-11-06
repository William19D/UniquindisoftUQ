package co.edu.uniquindio.utils;

import co.edu.uniquindio.model.Contributor;

import java.util.PriorityQueue;

public class ContributorQueue {
    private PriorityQueue<Contributor> contributores;

    public ContributorQueue() {
        contributores = new PriorityQueue<>();
    }

    public void addContributor(Contributor contributor) {
        contributores.add(contributor);
    }

    public Contributor getContributor() {
        return contributores.poll();
    }
}