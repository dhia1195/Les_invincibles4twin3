<?php

namespace App\Test\Controller;

use App\Entity\Blog;
use App\Repository\BlogRepository;
use Symfony\Bundle\FrameworkBundle\KernelBrowser;
use Symfony\Bundle\FrameworkBundle\Test\WebTestCase;

class BlogControllerTest extends WebTestCase
{
    private KernelBrowser $client;
    private BlogRepository $repository;
    private string $path = '/blog/';

    protected function setUp(): void
    {
        $this->client = static::createClient();
        $this->repository = static::getContainer()->get('doctrine')->getRepository(Blog::class);

        foreach ($this->repository->findAll() as $object) {
            $this->repository->remove($object, true);
        }
    }

    public function testIndex(): void
    {
        $crawler = $this->client->request('GET', $this->path);

        self::assertResponseStatusCodeSame(200);
        self::assertPageTitleContains('Blog index');

        // Use the $crawler to perform additional assertions e.g.
        // self::assertSame('Some text on the page', $crawler->filter('.p')->first());
    }

    public function testNew(): void
    {
        $originalNumObjectsInRepository = count($this->repository->findAll());

        $this->markTestIncomplete();
        $this->client->request('GET', sprintf('%snew', $this->path));

        self::assertResponseStatusCodeSame(200);

        $this->client->submitForm('Save', [
            'blog[title]' => 'Testing',
            'blog[contenue]' => 'Testing',
            'blog[datecreation]' => 'Testing',
            'blog[hidden]' => 'Testing',
            'blog[actor]' => 'Testing',
        ]);

        self::assertResponseRedirects('/blog/');

        self::assertSame($originalNumObjectsInRepository + 1, count($this->repository->findAll()));
    }

    public function testShow(): void
    {
        $this->markTestIncomplete();
        $fixture = new Blog();
        $fixture->setTitle('My Title');
        $fixture->setContenue('My Title');
        $fixture->setDatecreation('My Title');
        $fixture->setHidden('My Title');
        $fixture->setActor('My Title');

        $this->repository->save($fixture, true);

        $this->client->request('GET', sprintf('%s%s', $this->path, $fixture->getId()));

        self::assertResponseStatusCodeSame(200);
        self::assertPageTitleContains('Blog');

        // Use assertions to check that the properties are properly displayed.
    }

    public function testEdit(): void
    {
        $this->markTestIncomplete();
        $fixture = new Blog();
        $fixture->setTitle('My Title');
        $fixture->setContenue('My Title');
        $fixture->setDatecreation('My Title');
        $fixture->setHidden('My Title');
        $fixture->setActor('My Title');

        $this->repository->save($fixture, true);

        $this->client->request('GET', sprintf('%s%s/edit', $this->path, $fixture->getId()));

        $this->client->submitForm('Update', [
            'blog[title]' => 'Something New',
            'blog[contenue]' => 'Something New',
            'blog[datecreation]' => 'Something New',
            'blog[hidden]' => 'Something New',
            'blog[actor]' => 'Something New',
        ]);

        self::assertResponseRedirects('/blog/');

        $fixture = $this->repository->findAll();

        self::assertSame('Something New', $fixture[0]->getTitle());
        self::assertSame('Something New', $fixture[0]->getContenue());
        self::assertSame('Something New', $fixture[0]->getDatecreation());
        self::assertSame('Something New', $fixture[0]->getHidden());
        self::assertSame('Something New', $fixture[0]->getActor());
    }

    public function testRemove(): void
    {
        $this->markTestIncomplete();

        $originalNumObjectsInRepository = count($this->repository->findAll());

        $fixture = new Blog();
        $fixture->setTitle('My Title');
        $fixture->setContenue('My Title');
        $fixture->setDatecreation('My Title');
        $fixture->setHidden('My Title');
        $fixture->setActor('My Title');

        $this->repository->save($fixture, true);

        self::assertSame($originalNumObjectsInRepository + 1, count($this->repository->findAll()));

        $this->client->request('GET', sprintf('%s%s', $this->path, $fixture->getId()));
        $this->client->submitForm('Delete');

        self::assertSame($originalNumObjectsInRepository, count($this->repository->findAll()));
        self::assertResponseRedirects('/blog/');
    }
}
